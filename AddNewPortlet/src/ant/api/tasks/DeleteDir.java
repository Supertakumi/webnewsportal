package ant.api.tasks;

import org.apache.tools.ant.taskdefs.Delete;
import org.apache.tools.ant.types.FileSet;

public class DeleteDir extends Delete{
	public DeleteDir(FileSet fileSet, boolean includeEmptyDir, boolean quietMode){
		
		this.addFileset(fileSet);
		this.setIncludeEmptyDirs(includeEmptyDir);
		this.setQuiet(quietMode);
		this.init();
	}
}
