-- idempotenza in sviluppo
DROP TABLE IF EXISTS public.pedigree CASCADE;

CREATE TABLE public.pedigree (
                                 id               BIGINT NOT NULL,
                                 patient_id       BIGINT NOT NULL,
                                 data             JSONB  NOT NULL,
                                 created_by       BIGINT NOT NULL,
                                 created_at       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
                                 last_modified    TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
                                 last_modified_by BIGINT NOT NULL
);

-- identity come nelle altre tabelle del tuo dump
ALTER TABLE public.pedigree
    ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
        SEQUENCE NAME public.pedigree_id_seq
        START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1
        );

-- chiave primaria
ALTER TABLE ONLY public.pedigree
    ADD CONSTRAINT pedigree_pkey PRIMARY KEY (id);

-- foreign keys (adattate a patient.id e users.user_id)
ALTER TABLE ONLY public.pedigree
    ADD CONSTRAINT fk_pedigree_patient
        FOREIGN KEY (patient_id) REFERENCES public.patient(id) ON DELETE CASCADE;

ALTER TABLE ONLY public.pedigree
    ADD CONSTRAINT fk_pedigree_created_by
        FOREIGN KEY (created_by) REFERENCES public.users(user_id) ON DELETE RESTRICT;

ALTER TABLE ONLY public.pedigree
    ADD CONSTRAINT fk_pedigree_last_modified_by
        FOREIGN KEY (last_modified_by) REFERENCES public.users(user_id) ON DELETE RESTRICT;

-- indici utili
CREATE INDEX IF NOT EXISTS ix_pedigree_patient        ON public.pedigree(patient_id);
CREATE INDEX IF NOT EXISTS ix_pedigree_created_by     ON public.pedigree(created_by);
CREATE INDEX IF NOT EXISTS ix_pedigree_last_modified_by ON public.pedigree(last_modified_by);
CREATE INDEX IF NOT EXISTS ix_pedigree_data_gin       ON public.pedigree USING gin(data);

-- trigger per aggiornare last_modified ad ogni UPDATE
CREATE OR REPLACE FUNCTION public.set_pedigree_last_modified()
    RETURNS trigger LANGUAGE plpgsql AS $$
BEGIN
    NEW.last_modified := now();
    RETURN NEW;
END$$;

DROP TRIGGER IF EXISTS trg_pedigree_set_last_modified ON public.pedigree;
CREATE TRIGGER trg_pedigree_set_last_modified
    BEFORE UPDATE ON public.pedigree
    FOR EACH ROW EXECUTE FUNCTION public.set_pedigree_last_modified();
