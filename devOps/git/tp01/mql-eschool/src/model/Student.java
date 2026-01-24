package model;

import java.util.UUID;

public record Student (
    UUID id, String name, String password, String mail
) 
{}
