package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * http://localhost:8080/request-body-json
 *
 * JSON 형식 전송
 * content-type: application/json
 * message body: {"username": "hello", "age": 20}
 *
 */
@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletInputStream inputStream = request.getInputStream(); // inputStream 은 byte 코드를 반환
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); // byte -> UTF_8

        System.out.println("messageBody = " + messageBody); // 클라이언트에서 메시지 바디를 통해 서버로 데이터를 넘김.

        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class); // 넘어온 데이터를 기반으로 해당 객체에 값을 set 한 뒤 객체 반환.
        System.out.println("helloData.username = " + helloData.getUserName());
        System.out.println("helloData.age = " + helloData.getAge());
        response.getWriter().write("ok");

    }

    /**
     * Jackson, Gson: JSON 변환 라이브러리
     * Spring Boot 는 기본으로 Jackson(ObjectMapper) 라이브러리를 제공한다.
     * ObjectMapper.readValue(String, Object): Json 형식의 데이터를 읽어 특정 객체로 반환한다.
     */

}