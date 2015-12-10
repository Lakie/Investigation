package com.unesasoft.spring;

/**
 * Created by Slavyanin on 27.07.2015.
 */
//@Configuration
//@ComponentScan(basePackages = { "com.unesasoft.security" })
//@EnableWebSecurity
public class SecSecurityConfig{
//        extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
//
//    public SecSecurityConfig() {
//        super();
//    }
//
//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authProvider());
//    }
//
//    @Override
//    public void configure(final WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/**");
//    }
//
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        // @formatter:off
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/j_spring_security_check*","/login*", "/logout*", "/signin/**", "/signup/**",
//                        "/user/registration*", "/regitrationConfirm*", "/expiredAccount*", "/registration*",
//                        "/badUser*", "/user/resendRegistrationToken*" ,"/forgetPassword*", "/user/resetPassword*",
//                        "/user/changePassword*", "/emailError*", "/resources/**","/old/user/registration*","/successRegister*").permitAll()
//                .antMatchers("/invalidSession*").anonymous()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/j_spring_security_check")
//                .defaultSuccessUrl("/homepage.html")
//                .failureUrl("/login.html?error=true")
//                .successHandler(myAuthenticationSuccessHandler)
//                .usernameParameter("j_username")
//                .passwordParameter("j_password")
//                .permitAll()
//                .and()
//                .sessionManagement()
//                .invalidSessionUrl("/invalidSession.html")
//                .sessionFixation().none()
//                .and()
//                .logout()
//                .invalidateHttpSession(false)
//                .logoutUrl("/j_spring_security_logout")
//                .logoutSuccessUrl("/logout.html?logSucc=true")
//                .deleteCookies("JSESSIONID")
//                .permitAll();
//        // @formatter:on
//    }
//
//    // beans
//
//    @Bean
//    public DaoAuthenticationProvider authProvider() {
//        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(encoder());
//        return authProvider;
//    }
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder(11);
//    }
}
