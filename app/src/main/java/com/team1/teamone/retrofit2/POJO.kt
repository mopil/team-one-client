package com.team1.teamone.retrofit2

import com.google.gson.annotations.SerializedName

/*
{
    "member": {
        "id": 12,
        "userId": "userid144",
        "password": "932f3c1b56257ce8539ac269d7aab42550dacf8818d075f0bdf1990562aae3ef",
        "email": "sectionr0244@gmail.com",
        "userName": "usernametest",
        "department": "컴퓨터공학과",
        "schoolId": "6017",
        "phoneNumber": "010-1234-1234",
        "nickname": "tester1",
        "star": 0.0,
        "point": 0,
        "introduce": null,
        "authToken": "ASDFASDF1",
        "memberType": "USER"
    },
    "sessionId": "0C1B22872E41DF66B26E3A37E3FEC739"
}
*/

data class MemberDto(
    var id: Long? = null,
    var userId: String? = null,
    var password: String? = null,
    var email: String? = null,
    var userName: String? = null,
    var department: String? = null,
    var schoolId: String? = null,
    var phoneNumber: String? = null,
    var nickname: String? = null,
    var stars: Double? = null,
    var points: Int? = null,
    var introduce: String? = null,
    var authToken: String? = null,
    var memberType: String? = null
)

data class PostMemberDto(
    @SerializedName("member")
    var member: List<MemberDto>,
    @SerializedName("sessionId")
    var sessionId: String? = null
)

data class PostLoginModel(
    var userId: String? = null,
    var password: String? = null
)


/*
* {
    "userName" : "usernametest",
    "department" : "컴퓨터공학과",
    "schoolId" : "6017",
    "phoneNumber" : "010-1234-1234",
    "nickname" : "tester1",
    "userId" : "userid1445",
    "password" : "123123123",
    "passwordCheck" : "123123123",
    "email" : "sectionr02445@gmail.com",
    "authToken" : "ASDFASDF1"
}
* */

data class PostRegisterModel(
    var userName: String? = null,
    var department: String? = null,
    var schoolId: String? = null,
    var phoneNumber: String? = null,
    var nickname: String? = null,
    var userId: String? = null,
    var password: String? = null,
    var passwordCheck: String? = null,
    var email: String? = null,
    var authToken: String? = null
)
