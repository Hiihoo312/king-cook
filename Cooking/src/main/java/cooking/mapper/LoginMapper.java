package cooking.mapper;

import org.apache.ibatis.annotations.Mapper;

import cooking.dto.Account;

@Mapper

public interface LoginMapper {

    public Account findAccount(String userName);
}