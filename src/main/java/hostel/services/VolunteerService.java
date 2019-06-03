package main.java.hostel.services;

import main.java.hostel.configuration.RepositoryConfig;
import main.java.hostel.controller.dto.VolunteerDto;
import main.java.hostel.domain.entity.Volunteer;
import main.java.hostel.domain.repository.VolunteerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class VolunteerService {

    private VolunteerRepository volunteerRepository = RepositoryConfig.getInstance().getVolunteerRepository();
    private AuditService auditService = AuditService.getInstance();

    public VolunteerService() {
    }

    private void printVolunteers(List<Volunteer> result) {
        for (Volunteer v : result) {
            System.out.println(v.getName() + " from " + v.getOriginCountry());
        }
    }

    public void printAllVolunteers() {
        auditService.printActionsDetails("printAllVolunteers");
        printVolunteers(volunteerRepository.getVolunteers());
    }

    public void createNewVolunteer(String cnp, String name) {
        Volunteer volunteer = new Volunteer();
        volunteer.setCnp(cnp);
        volunteer.setName(name);
        volunteerRepository.insertVolunteer(volunteer);
    }

    public List<VolunteerDto> getAllVolunteers() {
        List<VolunteerDto> resultedList  = new ArrayList<>();
        for (Volunteer v : volunteerRepository.getVolunteers()) {
            resultedList.add(new VolunteerDto(v));
        }
        return resultedList;
    }

    public void updateVolunteer(String cnp, String name, String originCountry) {
        volunteerRepository.updateUser(cnp, name, originCountry);
    }

    public void deleteVolunteer(Volunteer volunteer) {
        volunteerRepository.deleteVolunteer(volunteer);
    }
}
