package application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerformingVesselDto {

        private Long id;

        private ClearedVesselDto clearedVessel;

        //private Long loadingWindow;

        private String schedule;

        private String handling;

        private String sailed;
    }

