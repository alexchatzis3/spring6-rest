package gr.aueb.cf.schoolapp.mapper;

import gr.aueb.cf.schoolapp.dto.*;
import gr.aueb.cf.schoolapp.model.PersonalInfo;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mapper {

    // private final PasswordEncoder passwordEncoder

    public TeacherReadOnlyDTO mapToTeacherReadOnlyDTO(Teacher teacher) {
        var dto = new TeacherReadOnlyDTO();

        dto.setId(teacher.getId());
        dto.setUuid(teacher.getUuid());
        dto.setIsActive(teacher.getIsActive());

        // map to UserReadOnlyDTO
        var userDTO = new UserReadOnlyDTO();
        userDTO.setFirstname(teacher.getUser().getFirstname());
        userDTO.setLastname(teacher.getUser().getLastname());
        userDTO.setVat(teacher.getUser().getVat());
        dto.setUser(userDTO);

        // map to PersonalInfoDTO
        var personalInfoDTO = new PersonalInfoReadOnlyDTO();
        personalInfoDTO.setAmka(teacher.getPersonalInfo().getAmka());
        personalInfoDTO.setIdentityNumber(teacher.getPersonalInfo().getIdentityNumber());
        dto.setPersonalInfo(personalInfoDTO);

        return dto;
    }



    public Teacher mapToTeacherEntity(TeacherInsertDTO teacherInsertDTO) {
        Teacher teacher = new Teacher();
        teacher.setIsActive(teacherInsertDTO.getIsActive());

        User user = new User();
        UserInsertDTO userInsertDTO = teacherInsertDTO.getUser();
        user.setFirstname(userInsertDTO.getFirstname());
        user.setLastname(userInsertDTO.getLastname());
        user.setUsername(userInsertDTO.getUsername());
        user.setPassword(userInsertDTO.getPassword());
        user.setFatherName(userInsertDTO.getFatherName());
        user.setMotherName(userInsertDTO.getMotherName());
        user.setFatherLastname(userInsertDTO.getFatherLastname());
        user.setMotherLastname(userInsertDTO.getMotherLastname());
        user.setDateOfBirth(userInsertDTO.getDateOfBirth());
        user.setGender(userInsertDTO.getGender());
        user.setRole(userInsertDTO.getRole());
        user.setIsActive(userInsertDTO.getIsActive());
        teacher.setUser(user);

        PersonalInfoInsertDTO personalInfoInsertDTO;
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setAmka(personalInfo.getAmka());
        personalInfo.setIdentityNumber(personalInfo.getIdentityNumber());
        personalInfo.setPlaceOfBirth(personalInfo.getPlaceOfBirth());
        personalInfo.setMunicipalityOfRegistration(personalInfo.getMunicipalityOfRegistration());

        return teacher;
    }

}
