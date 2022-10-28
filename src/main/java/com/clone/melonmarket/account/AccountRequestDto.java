package com.clone.melonmarket.account;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
@Getter
@NoArgsConstructor
public class AccountRequestDto {


    @NotBlank(message = "아이디는 공백일 수 없습니다.")
    @Size(min = 4, max = 12, message = "아이디는 4~12 개의 영문소문자와 숫자만 허용합니다.")
    @Pattern(regexp = "[a-z\\d]*${4,12}", message = "아이디는 소문자와 숫자의 조합만 허용합니다.")
    private String email;

    @NotBlank(message = "이름은 공백일 수 없습니다.")
    private String accountName;

    @NotBlank(message = "비밀번호는 공백일 수 없습니다.")
    @Size(min = 8, max = 16, message = "비밀번호는 8~16 개의 문자만 허용합니다.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$"
            , message = "비밀번호는 무조건 영문, 숫자, 특수문자를 각각 1글자 이상 포함해야 합니다.")
    private String password;

    @NotBlank(message = "핸드폰 번호는 공백일 수 없습니다.")
    private String phoneNum;

    public void setEncodePwd(String encodePwd) {

        this.password = encodePwd;
    }

}