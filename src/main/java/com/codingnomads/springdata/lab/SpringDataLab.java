/* CodingNomads (C)2024 */
package com.codingnomads.springdata.lab;

import com.codingnomads.springdata.lab.models.Area;
import com.codingnomads.springdata.lab.models.Route;
import com.codingnomads.springdata.lab.repositories.AreaRepository;
import java.util.Arrays;
import java.util.List;

import com.codingnomads.springdata.lab.repositories.RouteRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository;
    private final RouteRepository routeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }
    @Transactional
    @Override
    public void run(String... args) throws Exception {

        if (areaRepository.findAll().size() == 0) {
            final List<Area> areas = areaRepository.saveAll(Arrays.asList(
                    Area.builder().code("G").build(),
                    Area.builder().code("H").build(),
                    Area.builder().code("Y").build(),
                    Area.builder().code("Z").build(),
                    Area.builder().code("A").build(),
                    Area.builder().code("B").build(),
                    Area.builder().code("C").build()
            ));
        }

        if (routeRepository.findAll().size() == 0) {
            final List<Route> routes = routeRepository.saveAll(Arrays.asList(
                    Route.builder()
                            .origin(areaRepository.findByCode("G"))
                            .destination(areaRepository.findByCode("H"))
                            .build(),
                    Route.builder()
                            .origin(areaRepository.findByCode("Y"))
                            .destination(areaRepository.findByCode("Z"))
                            .build(),
                    Route.builder()
                            .origin(areaRepository.findByCode("A"))
                            .destination(areaRepository.findByCode("B"))
                            .build(),
                    Route.builder()
                            .origin(areaRepository.findByCode("C"))
                            .destination(areaRepository.findByCode("G"))
                            .build()
            ));
        }
        List<Route> routes1 = routeRepository.findByOrigin_code("Y");
        for (Route route : routes1) {
            System.out.println(route.toString());

        }
    }
}


