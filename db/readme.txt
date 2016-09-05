关于数据库 脚本

1/ createDBUser.bat 执行此脚本可以创建新用户
使用方法：打开该脚本，在参数部分填写真实数据库信息，双击执行

sysPassword     sys用户的密码
domain          Oracle的数据库名
tablespace      用户所在表空间
createUserName  新用户名
password        新用户密码

2/ createDB.bat 执行此脚本可以创建该用户下的表，加载的数据库脚本查看 create.sql
打开该脚本，用真实用户来连接数据库

3/ dropDB.bat 执行此脚本可以删除该用户下的表，删除的数据库脚本查看 drop.sql
打开该脚本，用真实用户来连接数据库

4/ 要注意客户端与服务器的编码一致问题，否则可能出现中文乱码 http://www.cnblogs.com/panie2015/p/5807184.html