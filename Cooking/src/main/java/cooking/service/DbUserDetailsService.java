package cooking.service;

//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;

//@Service
//public class DbUserDetailsService implements UserDetailsService {
	/*
	@Autowired
	LoginMapper loginMapper;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String mailAddress)
	        throws UsernameNotFoundException {
	    //DBからユーザ情報を取得。
	    Account account = Optional.ofNullable(loginMapper.findAccount(mailAddress))
	            .orElseThrow(() -> new UsernameNotFoundException("User not found."));

	    return new DbUserDetails(account, getAuthorities(account));
	}

	*//**
		* 認証が通った時にこのユーザに与える権限の範囲を設定する。
		* @param account DBから取得したユーザ情報。
		* @return 権限の範囲のリスト。
		*//*
			private Collection<GrantedAuthority> getAuthorities(Account account) {
			 //認証が通った時にユーザに与える権限の範囲を設定する。
			 return AuthorityUtils.createAuthorityList("ROLE_USER");
			}
			*/
//}