package com.edutia.hopecare.donation.application.command;

public record UpdateDonationCommand(
        String donorName,
        String donorEmail,
        String donorPhone,
        String description) {

}
