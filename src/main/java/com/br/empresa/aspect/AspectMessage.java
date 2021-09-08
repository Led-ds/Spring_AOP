package com.br.empresa.aspect;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.br.empresa.domain.dto.RequestDTO;

@Aspect
@Component
public class AspectMessage {

	private RequestDTO dto;
	
	/*@ A proposta aqui é ouvir os pacotes e sub pacotes definidos independente do projeto.
	 * basta ter o mesmo prefixo 'com.br' os primeiros dois pontos é o nome do projeto, 
	 * em seguida os pacotes*/
	
	@AfterThrowing(pointcut = "execution(* com.br..controller..*(..)) || "
							+ "execution(* com.br..service..*(..)) || "
							+ "execution(* com.br..config..*(..))", throwing = "ex" )
	public void listenToException(JoinPoint joinPoint, Throwable ex) throws Throwable{
		dto = new RequestDTO();
		
		dto.setTitle(joinPoint.getTarget().getClass().getSimpleName());
		dto.setMessage(ex.getMessage());
		dto.setDescription(getTrace(ex));
	}
	
	private String getTrace(Throwable e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}
}
