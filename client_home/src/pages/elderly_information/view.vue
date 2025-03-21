<template>
  <view>
    <view class="container diy_view">
      <view>
        <view>
          <view class="">
            <uni-forms :modelValue="form"  v-if="is_view()">

              <uni-forms-item v-if="$check_field('get','elderly_users') || ($check_field('add','elderly_users') || $check_field('set','elderly_users'))" label="老人用户" name="elderly_users">
                    <uni-data-select
                  id="form_elderly_users"
                  v-model="form['elderly_users']"
                  :localdata="list_user_elderly_users"
                  :clear="!disabledObj['elderly_users_isDisabled']"
                  :disabled="disabledObj['elderly_users_isDisabled']"
                  v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','elderly_users')) || (!form['elderly_information_id'] && $check_field('add','elderly_users'))"
                ></uni-data-select>
                <uni-data-select
                  v-model="form['elderly_users']"
                  :localdata="list_user_elderly_users"
                  :clear="false"
                  :disabled="true"
                  v-else-if="$check_field('get','elderly_users')" id="elderly_users"
                ></uni-data-select>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','family_members_of_the_elderly') || ($check_field('add','family_members_of_the_elderly') || $check_field('set','family_members_of_the_elderly'))" label="老人家属" name="family_members_of_the_elderly">
                    <uni-data-select
                  id="form_family_members_of_the_elderly"
                  v-model="form['family_members_of_the_elderly']"
                  :localdata="list_user_family_members_of_the_elderly"
                  :clear="!disabledObj['family_members_of_the_elderly_isDisabled']"
                  :disabled="disabledObj['family_members_of_the_elderly_isDisabled']"
                  v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','family_members_of_the_elderly')) || (!form['elderly_information_id'] && $check_field('add','family_members_of_the_elderly'))"
                ></uni-data-select>
                <uni-data-select
                  v-model="form['family_members_of_the_elderly']"
                  :localdata="list_user_family_members_of_the_elderly"
                  :clear="false"
                  :disabled="true"
                  v-else-if="$check_field('get','family_members_of_the_elderly')" id="family_members_of_the_elderly"
                ></uni-data-select>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','full_name') || ($check_field('add','full_name') || $check_field('set','full_name'))" label="姓名" name="full_name">
                            <uni-easyinput type="text" v-model="form['full_name']" v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','full_name')) || (!form['elderly_information_id'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','full_name')">
                  {{ form['full_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','gender') || ($check_field('add','gender') || $check_field('set','gender'))" label="性别" name="gender">
                    <uni-data-select
                  v-model="form.gender"
                  :localdata="list_gender"
                  :clear="!disabledObj['gender_isDisabled']"
                  :disabled="disabledObj['gender_isDisabled']"
                  v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','gender')) || (!form['elderly_information_id'] && $check_field('add','gender'))"
                ></uni-data-select>
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','gender')">
                  {{ form['gender'] }}
                </text>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','age') || ($check_field('add','age') || $check_field('set','age'))" label="年龄" name="age">
                            <uni-easyinput type="text" v-model="form['age']" v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','age')) || (!form['elderly_information_id'] && $check_field('add','age'))" :disabled="disabledObj['age_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','age')">
                  {{ form['age'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','id_number') || ($check_field('add','id_number') || $check_field('set','id_number'))" label="身份证号" name="id_number">
                            <uni-easyinput type="text" v-model="form['id_number']" v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','id_number')) || (!form['elderly_information_id'] && $check_field('add','id_number'))" :disabled="disabledObj['id_number_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','id_number')">
                  {{ form['id_number'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','contact_information') || ($check_field('add','contact_information') || $check_field('set','contact_information'))" label="联系方式" name="contact_information">
                            <uni-easyinput type="text" v-model="form['contact_information']" v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','contact_information')) || (!form['elderly_information_id'] && $check_field('add','contact_information'))" :disabled="disabledObj['contact_information_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','contact_information')">
                  {{ form['contact_information'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','home_address') || ($check_field('add','home_address') || $check_field('set','home_address'))" label="家庭住址" name="home_address">
                            <uni-easyinput type="text" v-model="form['home_address']" v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','home_address')) || (!form['elderly_information_id'] && $check_field('add','home_address'))" :disabled="disabledObj['home_address_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','home_address')">
                  {{ form['home_address'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','remarks') || ($check_field('add','remarks') || $check_field('set','remarks'))" label="备注信息" name="remarks">
                    <uni-easyinput type="textarea" v-model="form['remarks']" v-if="user_group === '管理员' || (form['elderly_information_id'] && $check_field('set','remarks')) || (!form['elderly_information_id'] && $check_field('add','remarks'))" :disabled="disabledObj['remarks_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','remarks')">
                  {{ form['remarks'] }}
                </text>
                  </uni-forms-item>


            </uni-forms>
            <view class="form_button">
              <button size="mini" type="primary" @click="submit()" class="primary_btn">提交</button>
              <button size="mini" @click="cancel()">取消</button>
            </view>
          </view>
        </view>
      </view>
    </view>
  </view>
</template>

<script>
import mixin from "@/libs/mixins/page.js";

export default {
  mixins: [mixin],
  data() {
    return {
      field: "elderly_information_id",
      url_add: "~/api/elderly_information/add?",
      url_set: "~/api/elderly_information/set?",
      url_get_obj: "~/api/elderly_information/get_obj?",
      url_upload: "~/api/elderly_information/upload?",

      query: {
        "elderly_information_id": 0,
      },

      form: {
            "elderly_users": 0, // 老人用户
                    "family_members_of_the_elderly": 0, // 老人家属
                    "full_name":  '', // 姓名
                    "gender":  '', // 性别
                    "age":  '', // 年龄
                    "id_number":  '', // 身份证号
                    "contact_information":  '', // 联系方式
                    "home_address":  '', // 家庭住址
                    "remarks":  '', // 备注信息
                                "elderly_information_id": 0, // ID
                
              },
          disabledObj:{
                        "elderly_users_isDisabled": false,
                                "family_members_of_the_elderly_isDisabled": false,
                                "full_name_isDisabled": false,
                                "gender_isDisabled": false,
                                "age_isDisabled": false,
                                "id_number_isDisabled": false,
                                "contact_information_isDisabled": false,
                                "home_address_isDisabled": false,
                                "remarks_isDisabled": false,
                                  },
                                // 用户列表
            list_user_elderly_users: [],
                                                    // 用户列表
            list_user_family_members_of_the_elderly: [],
                        // 用户组
            group_user_family_members_of_the_elderly: "",
                                                              // 性别选项列表
          list_gender: [],
                                                                                                                                          }
  },
  methods: {
    changeLog(v,value){
      this.form[value] = v
    },
    /**
     * 上传文件
     * @param {Object} param文件参数
     */
    change_file(key_name){
      var _self = this;
      // 选择图像方法
      uni.chooseFile({
        count: 1,
        sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
        sourceType: ['album'], //从相册选择
        success: function(res) {
          const tempFilePaths = res.tempFilePaths;
          const uploadTask = uni.uploadFile({
            url: _self.$fullUrl('/api/elderly_information/upload?'),
            filePath: tempFilePaths[0],
            name: 'file',
            formData: {
              'i_want_to_customize': 'test'
            },
            header: {
              'x-auth-token': _self.$store.state.user.token
            },
            success: function(uploadFileRes) {
              var filename = JSON.parse(uploadFileRes.data).result.url
              _self.form[key_name] = filename
            }
          });

          uploadTask.onProgressUpdate(function(res) {
            _self.percent = res.progress;
            console.log('上传进度' + res.progress);
            console.log('已经上传的数据长度' + res.totalBytesSent);
            console.log('预期需要上传的数据总长度' + res.totalBytesExpectedToSend);
          });
        },
        error: function(e) {
          console.log(e);
        }
      });
    },
    /**
     * 上传图片
     * @param {Object} param文件参数
     */
    change_img(key_name){
      var _self = this;
      _self.upload_img_flag = false
      // 选择图像方法
      uni.chooseImage({
        count: 1,
        sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
        sourceType: ['album'], //从相册选择
        success: function(res) {
          const tempFilePaths = res.tempFilePaths;
          const uploadTask = uni.uploadFile({
            url: _self.$fullUrl('/api/elderly_information/upload?'),
            filePath: tempFilePaths[0],
            name: 'file',
            formData: {
              'i_want_to_customize': 'test'
            },
            header: {
              'x-auth-token': _self.$store.state.user.token
            },
            success: function(uploadFileRes) {
              var filename = JSON.parse(uploadFileRes.data).result.url
              _self.form[key_name] = filename
            }
          });

          uploadTask.onProgressUpdate(function(res) {
            _self.percent = res.progress;
            console.log('上传进度' + res.progress);
            console.log('已经上传的数据长度' + res.totalBytesSent);
            console.log('预期需要上传的数据总长度' + res.totalBytesExpectedToSend);
          });
        },
        error: function(e) {
          console.log(e);
        }
      });
    },
    /**
     * 获取对象后获取缓存表单
     * @param {Object} json
     * @param {Object} func
     */
    get_obj_before(param){
      var form = uni.db.get("form");
      if (form) {
        delete(form.examine_state)
        delete(form.examine_reply)
        this.obj = uni.push(this.obj ,form);
        this.form = uni.push(this.form ,form);
      }
      var arr = []
      for (let key in form) {
        arr.push(key)
      }
      for (var i=0;i<arr.length;i++){
        this.disabledObj[arr[i] + '_isDisabled'] = true
      }
                                                                              uni.db.del("form");
      return param;
    },
            /**
     * 获取老人用户用户列表
     */
    async get_list_user_elderly_users() {
      // if(this.user_group !== "管理员" && this.form["elderly_users"] === 0) {
      //     this.form["elderly_users"] = this.user.user_id;
      // }
      var json = await this.$get("~/api/user/get_list?user_group=老人用户");
      if(json.result && json.result.list){
        json.result.list.map((o) => this.list_user_elderly_users.push({value:o.user_id,text:o.nickname + '-' + o.username}));
      }
      else if(json.error){
        console.error(json.error);
      }
    },
            
                /**
     * 获取老人家属用户列表
     */
    async get_list_user_family_members_of_the_elderly() {
      // if(this.user_group !== "管理员" && this.form["family_members_of_the_elderly"] === 0) {
      //     this.form["family_members_of_the_elderly"] = this.user.user_id;
      // }
      var json = await this.$get("~/api/user/get_list?user_group=老人家属");
      if(json.result && json.result.list){
        json.result.list.map((o) => this.list_user_family_members_of_the_elderly.push({value:o.user_id,text:o.nickname + '-' + o.username}));
      }
      else if(json.error){
        console.error(json.error);
      }
    },
            /**
     * 获取老人家属用户组
     */
    async get_group_user_family_members_of_the_elderly() {
      this.form["family_members_of_the_elderly"] = this.user.user_id;
      var json = await this.$get("~/api/user_group/get_obj?name=老人家属");
      if(json.result && json.result.obj){
        this.group_user_family_members_of_the_elderly = json.result.obj;
        this.get_user_session_family_members_of_the_elderly(this.form['family_members_of_the_elderly'])
      }
      else if(json.error){
        console.error(json.error);
      }
    },
    get_user_session_family_members_of_the_elderly(id){
      var _this = this;
      var user_id = {"user_id":id}
      var url = "~/api/"+_this.group_user_family_members_of_the_elderly.source_table+"/get_obj?"
      this.$get(url, user_id, function(res) {
        if (res.result && res.result.obj) {
          var arr = []
          for (let key in res.result.obj) {
            arr.push(key)
          }
          var arrForm = []
          for (let key in _this.form) {
            arrForm.push(key)
          }
          for (var i=0;i<arr.length;i++){
            if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
              for (var j = 0; j < arrForm.length; j++) {
                if (arr[i] === arrForm[j]) {
                  if (arr[i] !== "family_members_of_the_elderly") {
                    _this.form[arrForm[j]] = res.result.obj[arr[i]]
                    _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                    break;
                  } else {
                    _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                  }
                }
              }
            }
          }
        }
      });
    },
            
            
            /**
     * 获取性别列表
     */
    async get_list_gender() {
          ['男','女'].map((o) => this.list_gender.push({value:o,text:o}));
            },
        
            
            
            
            
            
    
    /**
     * 获取对象之后
     * @param {Object} json
     * @param {Object} func
     */
    get_obj_after(json, func){
                                                                            },

    is_view(){
      var bl = this.user_group == "管理员";

      if(!bl){
        bl = this.$check_action('/elderly_information/table','add');
        console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
      }
      if(!bl){
        bl = this.$check_action('/elderly_information/table','set');
        console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
      }
      if(!bl){
        bl = this.$check_action('/elderly_information/view','add');
        console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
      }
      if(!bl){
        bl = this.$check_action('/elderly_information/view','set');
        console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
      }
      if(!bl){
        bl = this.$check_action('/elderly_information/view','get');
        console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
      }

      console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

      return bl;
    },

  },
  created() {
            this.get_list_user_elderly_users();
                        this.get_list_user_family_members_of_the_elderly();
            this.get_group_user_family_members_of_the_elderly();
                            this.get_list_gender();
                                                  },
}
</script>

<style scoped>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.form_button{
  padding-bottom: 15px;
  display: flex;
}
.form_button button{
  width: 40%;
}
.query_select{
  border-color: rgb(229, 229, 229);
  background-color: rgb(255, 255, 255);
  border-radius: 4px;
  box-sizing: border-box;
  flex: 1;
  width: 100%;
  line-height: 2;
  font-size: 14px;
  height: 2.4em;
  min-height: 2.4em;
  display: block;
  outline:none;
}

.query_option{
  width: 100%;
}

.btn_add_img{
  color: #D3D3D3;
  text-align: center;
  border: 1px solid #eee;
  height: 5rem;
  width: 5rem;
  position: relative;
}
.btn_add_img text{
  font-size: 35px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%,-50%);
}
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}

.form_button {
  padding-bottom: 15px;
  display: flex;
}
.form_button button {
  width: 40%;
}
.query_select {
  border-color: rgb(229, 229, 229);
  background-color: rgb(255, 255, 255);
  border-radius: 4px;
  box-sizing: border-box;
  flex: 1;
  width: 100%;
  line-height: 2;
  font-size: 14px;
  height: 2.4em;
  min-height: 2.4em;
  display: block;
  outline: none;
}

.query_option {
  width: 100%;
}

.btn_add_img {
  color: #d3d3d3;
  text-align: center;
  border: 1px solid #eee;
  height: 5rem;
  width: 5rem;
  position: relative;
}
.btn_add_img text {
  font-size: 35px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
/*新样式*/
.uni-forms{
padding-top:1rem;
}
.uni-forms-item {
	padding: 6px 10px;
    background: #f8f6fc;
}
.uni-forms .is-input-border{
	border: 0;
}
.container{
	    -webkit-box-shadow: 0px 0px 0px #888888;
	    box-shadow: 0px 0px 0px #888888;
}
.form_button .primary_btn{
		background-color: #22B8B8;
		color: #FFFFFF;
	}
</style>
