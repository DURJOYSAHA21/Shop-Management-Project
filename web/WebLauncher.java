import java.lang.*;
import java.io.*;
import java.util.Enumeration;
import java.util.jar.*;

// Entry point for the browser live demo (CheerpJ).
// In the browser the app's working directory is /files/ (browser storage), which starts empty,
// so the images and data files bundled in app.jar are copied there on the first visit.
public class WebLauncher
{
	public static void main(String[] args) throws Exception
	{
		copyBundledFiles(args[0]);
		Start.main(args);
	}

	public static void copyBundledFiles(String jarPath) throws IOException
	{
		try(JarFile jar=new JarFile(jarPath))
		{
			Enumeration<JarEntry> entries=jar.entries();
			while(entries.hasMoreElements())
			{
				JarEntry e=entries.nextElement();
				String name=e.getName();
				if(e.isDirectory() || !(name.startsWith("images/") || name.startsWith("repositories/data/")))
				{
					continue;
				}
				File target=new File(name);
				if(target.exists())
				{
					continue;//keep the visitor's own accounts and orders from earlier visits
				}
				target.getParentFile().mkdirs();
				try(InputStream in=jar.getInputStream(e); OutputStream out=new FileOutputStream(target))
				{
					byte[] buf=new byte[8192];
					int n;
					while((n=in.read(buf))>0)
					{
						out.write(buf,0,n);
					}
				}
			}
		}
	}
}
