package com.example.charfrequence;

import com.example.charfrequence.services.ConversionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ConversionServiceTest {

    @Autowired
    private ConversionService conversionService;

    @Test
    public void testGetCharFrequency() throws Exception {
        String charSequence = "aaabccccaa";
        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("a", 5);
        expected.put("c", 4);
        expected.put("b", 1);

        Map<String, Integer> result = conversionService.getCharFrequency(charSequence);

        assertThat(expected.size()).isEqualTo(result.size());
        assertThat(expected).isEqualTo(result);
    }
}
