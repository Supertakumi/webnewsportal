package ant.api.tasks;

import java.io.File;

import org.apache.tools.ant.taskdefs.Copy;
import org.apache.tools.ant.types.FileSet;

public class CopyFiles extends Copy{
	
	public CopyFiles(String destDir, String fileSetSrcDir, String includePattern){
		this.init();
		FileSet fileSet = new FileSet();
		fileSet.setDir(new File(fileSetSrcDir));
		fileSet.setIncludes(includePattern);
		this.setTodir(new File(destDir));
		this.addFileset(fileSet);
		
	}
}
