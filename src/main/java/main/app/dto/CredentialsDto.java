package main.app.dto;



//Records are immutable only for reception so it's why i'am using here a record expression
public record CredentialsDto (String login , char[] password) {

}
