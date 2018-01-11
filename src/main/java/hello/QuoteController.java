package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteController {

    // New comment
    private static final String template = "Hello, %s!";

    @RequestMapping("/quote")
    public Quote greeting(@RequestParam(value="s", defaultValue=".INX") String symbol) {
        return new Quote(symbol);
    }
}
