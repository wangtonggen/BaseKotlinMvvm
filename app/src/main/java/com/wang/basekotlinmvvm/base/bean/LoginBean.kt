package com.wang.basemvvmkotlin.base.bean

/**
 *
 * author: wtg
 * date:2020/4/24 0024
 * desc:
 *
 */
class LoginBean : ProviderMultiEntity(){
    private var access_token //sos token
            : String? = null
    private var birthday //生日
            : String? = null
    private var cakeScore //巧克力数量
            : Int? = null
    private var carGroupNum //车圈数
            : Int? = null
    private var carName //车辆名称
            : String? = null
    private var carOwner //是否有车：0—暂时无车;1—有车一族; ,
            : Int? = null
    private var carType // 车辆类型
            : Int? = null
    private var cityName //所属城市
            : String? = null
    private var dataIntegeregrity //资料完整度
            : Int? = null
    private var distance //距离(单位m)
            = 0.0
    private var education //学历
            : String? = null
    private var experience //经验值
            : String? = null
    private var gender //性别
            : Int? = null
    private var headPhoto //头像
            : String? = null
    private var headVerify //是否真人头像认证：0—未认证;1—已认证
            : String? = null
    private var id //id
            : String? = null
    private var isBindMobile //是否绑定手机:0-否;1-是; 用于第三方登录跳转绑定手机页面
            : Int? = null
    private var isRegister //是否首次注册:0-不是;1-是; 用于判断登录后跳转首页还是完善信息页
            : Int? = null
    private var likeLabel //你喜欢的标签
            = false
    private var livePlace //居住地
            : String? = null
    private var lotteryNumber //抽奖次数
            : Int? = null
    private var membership //会员资格:0-非会员;1-会员
            : Int? = null
    private var mobile // 手机号
            : String? = null
    private var monthIncome //月收入
            : String? = null
    private var nickname //昵称
            : String? = null
    private var profession //职业
            : String? = null
    private var qqOpenId //QQ openid
            : String? = null
    private var realnameVerify //是否实名认证：0—未认证;1—已认证
            : String? = null
    private var starSeat //星座
            : String? = null
    private var token //身份认证
            : String? = null
    private var userOnline //用户是否在线：0—不在线;1—在线
            : String? = null
    private var userStatus //是否实名认证：0—未认证;1—已认证
            : Int? = null
    private var username //用户名
            : String? = null
    private var wxOpenId //微信openid
            : String? = null

    override fun getItemType(): Int {
        return userStatus!!
    }
}