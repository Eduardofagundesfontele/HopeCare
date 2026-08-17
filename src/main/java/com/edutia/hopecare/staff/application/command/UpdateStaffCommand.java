package com.edutia.hopecare.staff.application.command;

import com.edutia.hopecare.staff.domain.model.StaffRole;

public record UpdateStaffCommand(String name,
                                 String email,
                                 String phoneNumber,
                                 StaffRole staffRole) {
}
