-- REPORT
CREATE TABLE IF NOT EXISTS report (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    treatment_path_id BIGINT NOT NULL,
    patient_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    opening_date DATE NOT NULL,
    closing_date DATE,
    diagnosis TEXT NOT NULL,
    project_course TEXT NOT NULL,
    CONSTRAINT fk_report_treatment FOREIGN KEY (treatment_path_id) REFERENCES treatment_path(id) ON DELETE CASCADE,
    CONSTRAINT fk_report_patient FOREIGN KEY (patient_id) REFERENCES patient(id) ON DELETE CASCADE,
    CONSTRAINT fk_report_user FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);
