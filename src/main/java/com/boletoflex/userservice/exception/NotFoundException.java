package com.boletoflex.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public static final String ACCOUNT_ACCESS_BLOCK_NOT_FOUND = "account_access_block_not_found";
    public static final String ACCOUNT_DOOR_NOT_FOUND = "account_reader_not_found";
    public static final String ACCOUNT_COMMAND_NOT_FOUND = "account_command_not_found";
    public static final String ACCOUNT_RECEIVER_NOT_FOUND = "account_receiver_not_found";
    public static final String ACCOUNT_COMMAND_TO_READER_NOT_FOUND = "account_command_to_reader_not_found";
    public static final String ACCOUNT_DWELLER_NOT_FOUND = "account_dweller_not_found";
    public static final String MASTER_COMPANY_NOT_FOUND = "master_company_not_found";
    public static final String ACCOUNT_ACCESS_CONTROL_INTEGRATION_NOT_FOUND = "account_access_control_integration_not_found";
    public static final String ACCOUNT_DEWLLER_SERVICE_PROVIDER_NOT_FOUND = "account_dweller_service_provider_not_found";
    public static final String ACCOUNT_DWELLER_GUEST_NOT_FOUND = "account_dweller_guest_not_found";
    public static final String ACCOUNT_ACCESS_UNIT_NOT_FOUND = "account_access_unit_not_found";
    public static final String ACCOUNT_DWELLER_VEHICLE_NOT_FOUND = "account_dweller_vehicle_not_found";
    public static final String ZONE_NOT_FOUND = "zone_not_found";
    public static final String ACCOUNT_DWELLER_HARDWARE_NOT_FOUND = "account_dweller_hardware_not_found";
    public static final String ACCOUNT_DWELLER_DEVICE_DELETED_NOT_FOUND = "account_dweller_device_deleted_not_found";
    public static final String ACCOUNT_DWELLER_DEVICE_NOT_FOUND = "account_dweller_device_not_found";
    public static final String ACCOUNT_DWELLER_DELETED_NOT_FOUND = "account_dweller_deleted_not_found";
    public static final String SIAM_ACCESS_PROFILES_NOT_FOUND = "siam_access_profiles_not_found";
    public static final String DEVICE_ENROLL_HARDWARE_NOT_FOUND = "device_enroll_hardware_not_found";
    public static final String EXPORT_OPERATION_NOT_FOUND = "export_operation_not_found";

	public static final String USER_NOT_FOUND = "user_not_found";

    public NotFoundException(String message) {
        super(message);
    }

}
