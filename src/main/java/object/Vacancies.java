package object;

import lombok.Data;

@Data
public class Vacancies {
    String click;
    int vacancyId;
    String name;
    Company company;
}
