package com.dominika.msjuiceservice.bootstrap;

import java.math.BigDecimal;

import com.dominika.msjuiceservice.domain.Juice;
import com.dominika.msjuiceservice.repositories.JuiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JuiceLoader implements CommandLineRunner {

    private final JuiceRepository juiceRepository;

    @Override
    public void run(final String... args) throws Exception {
     loadJuiceObjects();
    }
    private void loadJuiceObjects() {
        if(juiceRepository.count()==0){
            juiceRepository.save(Juice.builder()
                .juiceName("Orange juice")
                .juiceStyle("raw")
                .quantityToBrew(200)
                .minOnHand(12)
                .upc(3335643000L)
                .price(new BigDecimal("12,95"))
                .build());
            juiceRepository.save(Juice.builder()
                .juiceName("Kiwi juice")
                .juiceStyle("raw")
                .quantityToBrew(210)
                .minOnHand(10)
                .upc(33356435300L)
                .price(new BigDecimal("10,95"))
                .build());
        }
        System.out.println("Loaded juices: " + juiceRepository.count());
    }
}