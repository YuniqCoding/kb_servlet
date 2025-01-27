package org.scoula.ex03.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter 어노테이션 적용해야 필터로 인식함
@WebFilter(urlPatterns = {"/*"}) // 모든 URL 패턴에 대해 필터를 적용하겠다
public class CharacterEncodeFilter implements Filter { // Filter 인터페이스 구현 필수!

    // 필터 초기화 메소드, 필터가 생성될때 호출된다
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    // 필터 소멸 메소드, 필터가 소멸될때 호출된다, 자원 해제 작업 수행
    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    // 실제 로직을 구현하는 메소드, request와 response를 받아올때 필터가 수행할 작업
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8"); //request의 문자 인코딩 UTF-8로 변경
        // 다음 필터나 서블릿으로 요청과 응답 전달
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
