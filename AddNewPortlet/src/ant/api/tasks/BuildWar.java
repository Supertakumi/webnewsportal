package ant.api.tasks;

import java.io.File;

import org.apache.tools.ant.taskdefs.War;
import org.apache.tools.ant.types.FileSet;
//import org.apache.tools.ant.types.Reference;

public class BuildWar extends War {
	public BuildWar(String destFile, String webXml, FileSet warFileSet){
		this.setDestFile(new File(destFile));
		this.setWebxml(new File(webXml));
		this.addFileset(warFileSet);
		this.log("Initializing Build");
		this.init();
	}
	
}