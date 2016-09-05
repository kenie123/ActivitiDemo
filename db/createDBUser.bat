@echo off

rem 请填写此部分的值
rem sys 用户的密码
set sysPassword=password

rem Oracle 的数据库名
set domain=orcl

rem 用户所在表空间
set tablespace=USERS

rem 新用户名
set createUserName=user123
rem 新用户密码
set password=user123
rem 请填写此部分的值

set createusersql=createuser/createuser.sql

echo create user %createUserName% identified by %password%; > %createusersql%
echo alter user %createUserName% default tablespace %tablespace% quota unlimited on %tablespace%; >> %createusersql%
echo alter user %createUserName% quota unlimited on %tablespace%; >> %createusersql%
echo alter user %createUserName% temporary tablespace temp; >> %createusersql%
echo grant create trigger to %createUserName%; >> %createusersql%
echo grant create session to %createUserName%; >> %createusersql%
echo grant create sequence to %createUserName%; >> %createusersql%
echo grant create synonym to %createUserName%; >> %createusersql%
echo grant create table to %createUserName%; >> %createusersql%
echo grant create view to %createUserName%; >> %createusersql%
echo grant create procedure to %createUserName%; >> %createusersql%
echo grant alter session to %createUserName%; >> %createusersql%
echo grant create job to %createUserName%; >> %createusersql%
echo grant dba to %createUserName%; >> %createusersql%
echo exit >> %createusersql%

echo.
echo [信息] 创建用户脚本已经生成。
echo [信息] 按任意键执行数据库脚本。
echo.
pause

sqlplus sys/%sysPassword%@%domain% as sysdba  @%createusersql%

echo.
echo [信息] 执行完成。
echo.
pause
