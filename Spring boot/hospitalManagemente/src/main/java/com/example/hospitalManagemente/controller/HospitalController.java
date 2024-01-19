import com.example.hospitalManagemente.model.PatientList;
import com.example.hospitalManagemente.service.HospitalService;
import com.example.hospitalManagemente.utility.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @RequestMapping("/patientsByDoctor")
    public ResponseEntity<List<PatientList>> findPatientsByDoctorName(@RequestParam String name) {
        List<PatientList> patients = hospitalService.findPatientsByDoctorName(name);

        // Generate PDF and save to a file
        String filePath = "patientList_" + name + ".pdf";
        try {
            PdfGenerator.generatePdf(patients, name, filePath);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok(patients);
    }
}
