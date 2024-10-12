package com.example.lab6_flutter.serviceIpm;

import com.example.lab6_flutter.entity.User;
import com.example.lab6_flutter.repository.UserRepository;
import com.example.lab6_flutter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userIpm implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public void register(User user) {
        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new RuntimeException("Email đã được sử dụng.");
        }else {
            // Mã hóa mật khẩu trước khi lưu
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userRepository.save(user);
        }
    }

    @Override
    public void login(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser == null) {
            throw new RuntimeException("Email không tồn tại");
        } else {
            if (passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
                System.out.println("Đăng nhập thành công");
            } else {
                throw new RuntimeException("Mật khẩu không đúng");
            }
        }
    }
}
