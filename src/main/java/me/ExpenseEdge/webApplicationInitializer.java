package me.ExpenseEdge;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

//Spring 프레임워크에서 웹 애플리케이션의 초기화를 담당하는 인터페이스, Java 기반의 웹 애플리케이션 설정
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class webApplicationInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		/* "ServletContext"를 매개변수로 받아, 필요한 서블릿과 필터를 등록. 즉, 필요한 서블릿의 매핑을 설정 + web.xml 대체 */
		//1. ContextLoaderListner
		initLisner(servletContext);
		
		//2. DispatcherServlet
		initServlet(servletContext);
		
		//3. Filter
		initFilter(servletContext);
	}

	private void initFilter(ServletContext servletContext) {
		/* Spring 프레임워크에서 애플리케이션 컨텍스트를 구성하는 데 사용되는 클래스 */
		AnnotationConfigWebApplicationContext wac = new AnnotationConfigWebApplicationContext();
		wac.register(AppConfig.class); //root-context.xml
		
		ContextLoaderListener listener = new ContextLoaderListener(wac);
		servletContext.addListener(listener);
	}

	private void initServlet(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext wac = new AnnotationConfigWebApplicationContext();
		wac.register(WebConfig.class); //servlet-context.xml
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(wac);
		
		// servlet mapping을 해주어야 하기 때문에 dynamic이 필요
		ServletRegistration.Dynamic servlet = servletContext.addServlet("appServlet", dispatcherServlet);
		
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}

	private void initLisner(ServletContext servletContext) {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true, true);
		
		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", characterEncodingFilter);
		
		filter.addMappingForUrlPatterns(null, false, "/*");
	}

}
