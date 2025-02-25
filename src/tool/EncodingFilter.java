package tool;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns={"/*"})
public class EncodingFilter implements Filter{
	public void doFilter(
		ServletRequest req,
		ServletResponse res,
		FilterChain chain
	) throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		chain.doFilter(req, res);
	}
	public void init(FilterConfig filterConfig) {}
	public void destroy() {}
}