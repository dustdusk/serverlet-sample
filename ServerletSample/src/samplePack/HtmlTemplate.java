package samplePack;

public class HtmlTemplate {
	public String genHeader(String title){
		StringBuffer header = new StringBuffer();
		header.append("<!DOCTYPE html>");
		header.append("<html>");
		header.append("<head>");
		header.append("<title>"+title+"</title>");
		header.append("</head>");
		header.append("<body>");
		return header.toString();
	}
	
	public String genfonter(){
		StringBuffer fonter = new StringBuffer();
		fonter.append("</body>");
		fonter.append("</html>");
		return fonter.toString();
	}
}
