package cooking.config;

//@Configuration

//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	/*
		@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    //ログインページを指定。
	    //ログインページへのアクセスは全員許可する。
	    http.formLogin()
	        .loginPage("/login")
	        .loginProcessingUrl("/authenticate")
	        .usernameParameter("uName")
	        .passwordParameter("uPwd")
	        .defaultSuccessUrl("/")
	        .permitAll();
	  //会員登録機能実装時に追加
	    http.authorizeRequests()
	    	.antMatchers("/RegistrationForm").permitAll()
	    	.antMatchers("/Register").permitAll()
	    	.antMatchers("/Result").permitAll()
	        .anyRequest().authenticated();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	@Autowired
	void configureAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService)
	        .passwordEncoder(passwordEncoder());
	}*/
