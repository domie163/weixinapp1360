<template>
  <view>
    <view class="container diy_view">
      <view>
        <view>
          <view class="">
            <uni-forms :modelValue="form"  v-if="is_view()">

              <uni-forms-item v-if="$check_field('get','order_number') || ($check_field('add','order_number') || $check_field('set','order_number'))" label="订单编号" name="order_number">
                            <uni-easyinput type="text" v-model="form['order_number']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','order_number')) || (!form['appointment_order_id'] && $check_field('add','order_number'))"  :disabled="true" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','order_number')">
                  {{ form['order_number'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','corporate_name') || ($check_field('add','corporate_name') || $check_field('set','corporate_name'))" label="公司名称" name="corporate_name">
                            <uni-easyinput type="text" v-model="form['corporate_name']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','corporate_name')) || (!form['appointment_order_id'] && $check_field('add','corporate_name'))" :disabled="disabledObj['corporate_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','corporate_name')">
                  {{ form['corporate_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','service_name') || ($check_field('add','service_name') || $check_field('set','service_name'))" label="服务名称" name="service_name">
                            <uni-easyinput type="text" v-model="form['service_name']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','service_name')) || (!form['appointment_order_id'] && $check_field('add','service_name'))" :disabled="disabledObj['service_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','service_name')">
                  {{ form['service_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','service_type') || ($check_field('add','service_type') || $check_field('set','service_type'))" label="服务类型" name="service_type">
                            <uni-easyinput type="text" v-model="form['service_type']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','service_type')) || (!form['appointment_order_id'] && $check_field('add','service_type'))" :disabled="disabledObj['service_type_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','service_type')">
                  {{ form['service_type'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','service_price') || ($check_field('add','service_price') || $check_field('set','service_price'))" label="服务价格" name="service_price">
                            <uni-easyinput type="text" v-model="form['service_price']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','service_price')) || (!form['appointment_order_id'] && $check_field('add','service_price'))" :disabled="disabledObj['service_price_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','service_price')">
                  {{ form['service_price'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','appointment_users') || ($check_field('add','appointment_users') || $check_field('set','appointment_users'))" label="预约用户" name="appointment_users">
                    <uni-data-select
                  id="form_appointment_users"
                  v-model="form['appointment_users']"
                  :localdata="list_user_appointment_users"
                  :clear="!disabledObj['appointment_users_isDisabled']"
                  :disabled="disabledObj['appointment_users_isDisabled']"
                  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','appointment_users')) || (!form['appointment_order_id'] && $check_field('add','appointment_users'))"
                ></uni-data-select>
                <uni-data-select
                  v-model="form['appointment_users']"
                  :localdata="list_user_appointment_users"
                  :clear="false"
                  :disabled="true"
                  v-else-if="$check_field('get','appointment_users')" id="appointment_users"
                ></uni-data-select>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','user_name') || ($check_field('add','user_name') || $check_field('set','user_name'))" label="用户姓名" name="user_name">
                            <uni-easyinput type="text" v-model="form['user_name']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','user_name')) || (!form['appointment_order_id'] && $check_field('add','user_name'))" :disabled="disabledObj['user_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','user_name')">
                  {{ form['user_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','elderly_users') || ($check_field('add','elderly_users') || $check_field('set','elderly_users'))" label="老人用户" name="elderly_users">
                    <uni-data-select
                  id="form_elderly_users"
                  v-model="form['elderly_users']"
                  :localdata="list_user_elderly_users"
                  :clear="!disabledObj['elderly_users_isDisabled']"
                  :disabled="disabledObj['elderly_users_isDisabled']"
                  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','elderly_users')) || (!form['appointment_order_id'] && $check_field('add','elderly_users'))"
                ></uni-data-select>
                <uni-data-select
                  v-model="form['elderly_users']"
                  :localdata="list_user_elderly_users"
                  :clear="false"
                  :disabled="true"
                  v-else-if="$check_field('get','elderly_users')" id="elderly_users"
                ></uni-data-select>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','time_of_appointment') || ($check_field('add','time_of_appointment') || $check_field('set','time_of_appointment'))" label="预约时间" name="time_of_appointment">
                    <uni-datetime-picker v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','time_of_appointment')) || (!form['appointment_order_id'] && $check_field('add','time_of_appointment'))" @change="changeLog($event,'time_of_appointment')" v-model="form['time_of_appointment']" type="datetime" :disabled="disabledObj['time_of_appointment_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','time_of_appointment')">
                  {{ form['time_of_appointment'] }}
                </text>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','appointment_notes') || ($check_field('add','appointment_notes') || $check_field('set','appointment_notes'))" label="预约备注" name="appointment_notes">
                    <uni-easyinput type="textarea" v-model="form['appointment_notes']" v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','appointment_notes')) || (!form['appointment_order_id'] && $check_field('add','appointment_notes'))" :disabled="disabledObj['appointment_notes_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','appointment_notes')">
                  {{ form['appointment_notes'] }}
                </text>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','order_status') || ($check_field('add','order_status') || $check_field('set','order_status'))" label="订单状态" name="order_status">
                    <uni-data-select
                  v-model="form.order_status"
                  :localdata="list_order_status"
                  :clear="!disabledObj['order_status_isDisabled']"
                  :disabled="disabledObj['order_status_isDisabled']"
                  v-if="user_group === '管理员' || (form['appointment_order_id'] && $check_field('set','order_status')) || (!form['appointment_order_id'] && $check_field('add','order_status'))"
                ></uni-data-select>
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','order_status')">
                  {{ form['order_status'] }}
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
      field: "appointment_order_id",
      url_add: "~/api/appointment_order/add?",
      url_set: "~/api/appointment_order/set?",
      url_get_obj: "~/api/appointment_order/get_obj?",
      url_upload: "~/api/appointment_order/upload?",

      query: {
        "appointment_order_id": 0,
      },

      form: {
            "order_number": this.$get_stamp(), // 订单编号
                    "corporate_name":  '', // 公司名称
                    "service_name":  '', // 服务名称
                    "service_type":  '', // 服务类型
                    "service_price":  '', // 服务价格
                    "appointment_users": 0, // 预约用户
                    "user_name":  '', // 用户姓名
                    "elderly_users": 0, // 老人用户
                    "time_of_appointment": this.$toTime(new Date().getTime(), "yyyy-MM-dd hh:mm:ss"),
                    "appointment_notes":  '', // 预约备注
                    "order_status":  '', // 订单状态
                                "appointment_order_id": 0, // ID
                
              },
          disabledObj:{
                        "order_number_isDisabled": false,
                                "corporate_name_isDisabled": false,
                                "service_name_isDisabled": false,
                                "service_type_isDisabled": false,
                                "service_price_isDisabled": false,
                                "appointment_users_isDisabled": false,
                                "user_name_isDisabled": false,
                                "elderly_users_isDisabled": false,
                                "time_of_appointment_isDisabled": false,
                                "appointment_notes_isDisabled": false,
                                "order_status_isDisabled": false,
                                  },
                                                                                                                                    // 用户列表
            list_user_appointment_users: [],
                        // 用户组
            group_user_appointment_users: "",
                                                                        // 用户列表
            list_user_elderly_users: [],
                                                                                  // 订单状态选项列表
          list_order_status: [],
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
            url: _self.$fullUrl('/api/appointment_order/upload?'),
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
            url: _self.$fullUrl('/api/appointment_order/upload?'),
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
                                                                          if (this.form["time_of_appointment"] && JSON.stringify(this.form["time_of_appointment"]).indexOf("-")===-1) {
        this.form["time_of_appointment"] = this.$toTime(parseInt(this.form["time_of_appointment"]), "yyyy-MM-dd hh:mm:ss")
      }
                              uni.db.del("form");
      return param;
    },
        
            
            
            
            
                /**
     * 获取老人家属用户列表
     */
    async get_list_user_appointment_users() {
      // if(this.user_group !== "管理员" && this.form["appointment_users"] === 0) {
      //     this.form["appointment_users"] = this.user.user_id;
      // }
      var json = await this.$get("~/api/user/get_list?user_group=老人家属");
      if(json.result && json.result.list){
        json.result.list.map((o) => this.list_user_appointment_users.push({value:o.user_id,text:o.nickname + '-' + o.username}));
      }
      else if(json.error){
        console.error(json.error);
      }
    },
            /**
     * 获取老人家属用户组
     */
    async get_group_user_appointment_users() {
      this.form["appointment_users"] = this.user.user_id;
      var json = await this.$get("~/api/user_group/get_obj?name=老人家属");
      if(json.result && json.result.obj){
        this.group_user_appointment_users = json.result.obj;
        this.get_user_session_appointment_users(this.form['appointment_users'])
      }
      else if(json.error){
        console.error(json.error);
      }
    },
    get_user_session_appointment_users(id){
      var _this = this;
      var user_id = {"user_id":id}
      var url = "~/api/"+_this.group_user_appointment_users.source_table+"/get_obj?"
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
                  if (arr[i] !== "appointment_users") {
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
     * 获取订单状态列表
     */
    async get_list_order_status() {
          ['未通过','已通过'].map((o) => this.list_order_status.push({value:o,text:o}));
            },
        
    
    /**
     * 获取对象之后
     * @param {Object} json
     * @param {Object} func
     */
    get_obj_after(json, func){
                                                                          if (this.form["time_of_appointment"] && JSON.stringify(this.form["time_of_appointment"]).indexOf("-")===-1) {
        this.form["time_of_appointment"] = this.$toTime(parseInt(this.form["time_of_appointment"]), "yyyy-MM-dd hh:mm:ss")
      }
                            },

    is_view(){
      var bl = this.user_group == "管理员";

      if(!bl){
        bl = this.$check_action('/appointment_order/table','add');
        console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
      }
      if(!bl){
        bl = this.$check_action('/appointment_order/table','set');
        console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
      }
      if(!bl){
        bl = this.$check_action('/appointment_order/view','add');
        console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
      }
      if(!bl){
        bl = this.$check_action('/appointment_order/view','set');
        console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
      }
      if(!bl){
        bl = this.$check_action('/appointment_order/view','get');
        console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
      }

      console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

      return bl;
    },

  },
  created() {
                                                    this.get_list_user_appointment_users();
            this.get_group_user_appointment_users();
                                this.get_list_user_elderly_users();
                                    this.get_list_order_status();
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
