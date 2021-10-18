package com.epam.brest.andreycheslow.model;

import static com.epam.brest.andreycheslow.model.StatusType.*;

public class Exit implements Status {

    @Override
    public Status handle() {
        return null;
    }

    @Override
    public StatusType getType() {
        return EXIT;
    }
}