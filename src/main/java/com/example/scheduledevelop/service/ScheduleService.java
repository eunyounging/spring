package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.ScheduleRequestDto;
import com.example.scheduledevelop.dto.ScheduleResponseDto;
import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserService userService;

    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

        return schedules
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    public ScheduleResponseDto findById(Long id) {
        return ScheduleResponseDto.toDto(findScheduleById(id));
    }

    private Schedule findScheduleById(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("잘못된 ID 값 입니다."));
    }

    public void deleteSchedule(Long id) {
        findScheduleById(id);
        scheduleRepository.deleteById(id);
    }

    @Transactional
    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        User user = userService.findUserById(scheduleRequestDto.getUserId());
        Schedule schedule = new Schedule(user, scheduleRequestDto.getTitle(), scheduleRequestDto.getDescription());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return ScheduleResponseDto.toDto(savedSchedule);
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto updateRequestDto) {
        Schedule schedule = findScheduleById(id);
        schedule.update(updateRequestDto.getTitle(), updateRequestDto.getDescription());
        return ScheduleResponseDto.toDto(schedule);
    }
}
