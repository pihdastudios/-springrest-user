package com.example.restuser.services;

import com.example.restuser.dto.ScheduleDto;
import com.example.restuser.entity.Schedule;
import com.example.restuser.repository.FilmRepository;
import com.example.restuser.repository.ScheduleRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    FilmRepository filmRepository;

    public void saveSchedule(ScheduleDto scheduleDto) {
        var schedule = new Schedule(0L, filmRepository.getById(scheduleDto.getFilm()), scheduleDto.getStartDateTime(), scheduleDto.getEndDateTime(), scheduleDto.getTicketPrice());
        scheduleRepository.save(schedule);
    }
}
