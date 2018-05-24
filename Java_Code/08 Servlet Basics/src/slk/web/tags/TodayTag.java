package slk.web.tags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TodayTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	private String format = null;
	
	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println(">>> From inside of TodayTag.doStartTag() method!");
		
		JspWriter out = pageContext.getOut();
		try {
			if(format==null){
				out.println(new Date());
			}
			else {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				out.println(sdf.format(new Date()));
			}
		} catch (IOException e) {
		}
		return super.doStartTag();
	}

	
}






