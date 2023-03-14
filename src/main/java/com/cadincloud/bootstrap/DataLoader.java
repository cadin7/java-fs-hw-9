package com.cadincloud.bootstrap;

import com.cadincloud.model.api.RoomFacilities;
import com.cadincloud.model.entity.CleaningProcedureEntity;
import com.cadincloud.model.entity.CleanupEntity;
import com.cadincloud.model.entity.RoomEntity;
import com.cadincloud.repository.CleaningProcedureRepository;
import com.cadincloud.repository.CleanupRepository;
import com.cadincloud.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final RoomRepository roomRepository;
    private final CleanupRepository cleanupRepository;
    private final CleaningProcedureRepository cleaningProcedureRepository;

    @Override
    public void run(String... args) throws Exception {
//        List<RoomFacilities> roomFacilities = List.of(
//                RoomFacilities.builder()
//                        .doubleBed(true)
//                        .tv(true)
//                        .build(),
//                RoomFacilities.builder()
//                        .doubleBed(false)
//                        .tv(true)
//                        .build(),
//                RoomFacilities.builder()
//                        .doubleBed(false)
//                        .tv(false)
//                        .build());
//
//        final var roomEntities = roomRepository.saveAll(List.of(
//                RoomEntity.builder()
//                        .number("101")
//                        .floor(1)
//                        .hotelName("Spring")
//                        .facilities(roomFacilities.get(2))
//                        .build(),
//                RoomEntity.builder()
//                        .number("102")
//                        .floor(1)
//                        .hotelName("Wing")
//                        .facilities(roomFacilities.get(1))
//                        .build(),
//                RoomEntity.builder()
//                        .number("201C")
//                        .floor(2)
//                        .hotelName("Lido")
//                        .facilities(roomFacilities.get(0))
//                        .build()));
//
//        final var cleanupEntities = cleanupRepository.saveAll(List.of(
//                CleanupEntity.builder()
//                        .date(LocalDate.now())
//                        .roomId(roomEntities.get(0).getId())
//                        .build(),
//                CleanupEntity.builder()
//                        .date(LocalDate.now())
//                        .roomId(roomEntities.get(1).getId())
//                        .build()));
//
//        final var cleanupProcedureEntities = cleaningProcedureRepository.saveAll(List.of(
//                CleaningProcedureEntity.builder()
//                        .name("dusting")
//                        .outcome(8)
//                        .cleanupId(cleanupEntities.get(0).getId())
//                        .build(),
//                CleaningProcedureEntity.builder()
//                        .name("vacuum cleaning")
//                        .outcome(10)
//                        .cleanupId(cleanupEntities.get(1).getId())
//                        .build(),
//                CleaningProcedureEntity.builder()
//                        .name("dusting")
//                        .outcome(9)
//                        .cleanupId(cleanupEntities.get(1).getId())
//                        .build()));
    }
}
