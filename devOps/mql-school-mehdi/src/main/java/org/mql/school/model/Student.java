package org.mql.school.model;

import java.util.UUID;

public record Student(
    UUID id, String username, String email) {

}
