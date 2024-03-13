package shop.mtcoding.blog.board;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.annotation.Native;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

    // @Transactional 트랜잭션 시간이 너무 길어져서 service에 넣어야함
    @PostMapping("/board/{id}/update")
    public String update(@PathVariable Integer id) {
        return "redirect:/board/" + id;
    }

    @GetMapping("/board/{id}/update-form")
    public String updateForm(@PathVariable(name = "id") Integer id, HttpServletRequest request) {
        return "/board/update-form"; // 서버가 내부적으로 index를 요청 - 외부에서는 다이렉트 접근이 안됨
    }

    @PostMapping("/board/{id}/delete")
    public String delete(@PathVariable Integer id) { // DTO 없이 구현
        return "redirect:/";
    }

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        return "index"; // 서버가 내부적으로 index를 요청 - 외부에서는 다이렉트 접근이 안됨
    }

    @PostMapping("/board/save")
    public String save() { // DTO 없이 구현
        return "redirect:/";
    }

    @GetMapping("/board/save-form")
    public String saveForm() {
        return "board/save-form";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable Integer id, HttpServletRequest request) { // Integer : 없으면 null, int : 0
        return "board/detail";
    }
}
