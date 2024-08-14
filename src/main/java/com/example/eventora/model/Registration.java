package com.example.eventora.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email address is invalid")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number is invalid")
    private String phone;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Event name is required")
    private String eventName;

    @Positive(message = "At least one ticket is required")
    private int tickets;

    @NotBlank(message = "Payment method is required")
    private String paymentMethod;

    private String cardNumber;
    private String accountNumber;
    private String upiId;

    
}