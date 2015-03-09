package experiments.code.listing;
import java.net.*;
import java.io.*;
public class FetchFileFromUrl {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://us.lrd.yahoo.com/_ylt=ApAWMUncMSlJuDmY14z_kWkVssB_;_ylu=X3oDMTFrdnA1OG9vBG1pdANSU1MgU2l0ZUluZGV4IFNwb3J0cwRwb3MDNARzZWMDTWVkaWFSU1NFZGl0b3JpYWw-;_ylg=X3oDMTFxZ2Z0cHViBGludGwDaW4EbGFuZwNlbi1pbgRwc3RhaWQDBHBzdGNhdANob21lfHNpdGVtYXAEcHQDc2VjdGlvbnM-;_ylv=0/SIG=11oo3iv2f/EXP=1349347802/**http%3A//in.news.yahoo.com/rss/cricket");
		//File file = new File("config.xml");
		
	    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"UTF8"));
		//BufferedReader br = new BufferedReader(new FileReader("config.xml"));
		//FileReader fr = new FileReader("config.xml");
		//FileOutputStream fw = new FileOutputStream("abc.xml");
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("abc.xml"),"UTF8"); 
		//BufferedWriter bw = new BufferedWriter(fw);
		
		String inputFile = null;
		while(in.readLine()!=null)
			{
				inputFile = in.readLine();
				System.out.println(inputFile);
				out.write(inputFile);
				out.write("\n");		
			}
		
		out.close();
		in.close();

	}

}