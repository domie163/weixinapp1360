<template>
  <view>
    <view class="container diy_view">
      <view>
        <view>
          <view class="">
            <uni-forms :modelValue="form"  v-if="is_view()">

              <uni-forms-item v-if="$check_field('get','insurance_name') || ($check_field('add','insurance_name') || $check_field('set','insurance_name'))" label="保险名称" name="insurance_name">
                            <uni-easyinput type="text" v-model="form['insurance_name']" v-if="user_group === '管理员' || (form['elderly_insurance_payment_id'] && $check_field('set','insurance_name')) || (!form['elderly_insurance_payment_id'] && $check_field('add','insurance_name'))" :disabled="disabledObj['insurance_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','insurance_name')">
                  {{ form['insurance_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','insurance_type') || ($check_field('add','insurance_type') || $check_field('set','insurance_type'))" label="保险类型" name="insurance_type">
                            <uni-easyinput type="text" v-model="form['insurance_type']" v-if="user_group === '管理员' || (form['elderly_insurance_payment_id'] && $check_field('set','insurance_type')) || (!form['elderly_insurance_payment_id'] && $check_field('add','insurance_type'))" :disabled="disabledObj['insurance_type_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','insurance_type')">
                  {{ form['insurance_type'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','insurance_price') || ($check_field('add','insurance_price') || $check_field('set','insurance_price'))" label="保险价格" name="insurance_price">
                            <uni-easyinput type="text" v-model="form['insurance_price']" v-if="user_group === '管理员' || (form['elderly_insurance_payment_id'] && $check_field('set','insurance_price')) || (!form['elderly_insurance_payment_id'] && $check_field('add','insurance_price'))" :disabled="disabledObj['insurance_price_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','insurance_price')">
                  {{ form['insurance_price'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','purchasing_users') || ($check_field('add','purchasing_users') || $check_field('set','purchasing_users'))" label="购买用户" name="purchasing_users">
                    <uni-data-select
                  id="form_purchasing_users"
                  v-model="form['purchasing_users']"
                  :localdata="list_user_purchasing_users"
                  :clear="!disabledObj['purchasing_users_isDisabled']"
                  :disabled="disabledObj['purchasing_users_isDisabled']"
                  v-if="user_group === '管理员' || (form['elderly_insurance_payment_id'] && $check_field('set','purchasing_users')) || (!form['elderly_insurance_payment_id'] && $check_field('add','purchasing_users'))"
                ></uni-data-select>
                <uni-data-select
                  v-model="form['purchasing_users']"
                  :localdata="list_user_purchasing_users"
                  :clear="false"
                  :disabled="true"
                  v-else-if="$check_field('get','purchasing_users')" id="purchasing_users"
                ></uni-data-select>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','user_name') || ($check_field('add','user_name') || $check_field('set','user_name'))" label="用户姓名" name="user_name">
                            <uni-easyinput type="text" v-model="form['user_name']" v-if="user_group === '管理员' || (form['elderly_insurance_payment_id'] && $check_field('set','user_name')) || (!form['elderly_insurance_payment_id'] && $check_field('add','user_name'))" :disabled="disabledObj['user_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','user_name')">
                  {{ form['user_name'] }}
                </text>
                          </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','purchase_date') || ($check_field('add','purchase_date') || $check_field('set','purchase_date'))" label="购买日期" name="purchase_date">
                    <uni-datetime-picker v-if="user_group === '管理员' || (form['elderly_insurance_payment_id'] && $check_field('set','purchase_date')) || (!form['elderly_insurance_payment_id'] && $check_field('add','purchase_date'))" v-model="form['purchase_date']" type="date" :disabled="disabledObj['purchase_date_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','purchase_date')">
                  {{ form['purchase_date'] }}
                </text>
                  </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','remarks') || ($check_field('add','remarks') || $check_field('set','remarks'))" label="备注信息" name="remarks">
                    <uni-easyinput type="textarea" v-model="form['remarks']" v-if="user_group === '管理员' || (form['elderly_insurance_payment_id'] && $check_field('set','remarks')) || (!form['elderly_insurance_payment_id'] && $check_field('add','remarks'))" :disabled="disabledObj['remarks_isDisabled']" />
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
      field: "elderly_insurance_payment_id",
      url_add: "~/api/elderly_insurance_payment/add?",
      url_set: "~/api/elderly_insurance_payment/set?",
      url_get_obj: "~/api/elderly_insurance_payment/get_obj?",
      url_upload: "~/api/elderly_insurance_payment/upload?",

      query: {
        "elderly_insurance_payment_id": 0,
      },

      form: {
            "insurance_name":  '', // 保险名称
                    "insurance_type":  '', // 保险类型
                    "insurance_price":  '', // 保险价格
                    "purchasing_users": 0, // 购买用户
                    "user_name":  '', // 用户姓名
                    "purchase_date": this.$toTime(new Date().getTime(), "yyyy-MM-dd"),
                    "remarks":  '', // 备注信息
                                "elderly_insurance_payment_id": 0, // ID
                
              },
          disabledObj:{
                        "insurance_name_isDisabled": false,
                                "insurance_type_isDisabled": false,
                                "insurance_price_isDisabled": false,
                                "purchasing_users_isDisabled": false,
                                "user_name_isDisabled": false,
                                "purchase_date_isDisabled": false,
                                "remarks_isDisabled": false,
                                  },
                                                                                            // 用户列表
            list_user_purchasing_users: [],
                        // 用户组
            group_user_purchasing_users: "",
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
            url: _self.$fullUrl('/api/elderly_insurance_payment/upload?'),
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
            url: _self.$fullUrl('/api/elderly_insurance_payment/upload?'),
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
                                                      if (this.form["purchase_date"] && JSON.stringify(this.form["purchase_date"]).indexOf("-")===-1) {
        this.form["purchase_date"] = this.$toTime(parseInt(this.form["purchase_date"]), "yyyy-MM-dd")
      }
                  uni.db.del("form");
      return param;
    },
        
            
            
                /**
     * 获取老人用户用户列表
     */
    async get_list_user_purchasing_users() {
      // if(this.user_group !== "管理员" && this.form["purchasing_users"] === 0) {
      //     this.form["purchasing_users"] = this.user.user_id;
      // }
      var json = await this.$get("~/api/user/get_list?user_group=老人用户");
      if(json.result && json.result.list){
        json.result.list.map((o) => this.list_user_purchasing_users.push({value:o.user_id,text:o.nickname + '-' + o.username}));
      }
      else if(json.error){
        console.error(json.error);
      }
    },
            /**
     * 获取老人用户用户组
     */
    async get_group_user_purchasing_users() {
      this.form["purchasing_users"] = this.user.user_id;
      var json = await this.$get("~/api/user_group/get_obj?name=老人用户");
      if(json.result && json.result.obj){
        this.group_user_purchasing_users = json.result.obj;
        this.get_user_session_purchasing_users(this.form['purchasing_users'])
      }
      else if(json.error){
        console.error(json.error);
      }
    },
    get_user_session_purchasing_users(id){
      var _this = this;
      var user_id = {"user_id":id}
      var url = "~/api/"+_this.group_user_purchasing_users.source_table+"/get_obj?"
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
                  if (arr[i] !== "purchasing_users") {
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
     * 获取对象之后
     * @param {Object} json
     * @param {Object} func
     */
    get_obj_after(json, func){
                                                      if (this.form["purchase_date"] && JSON.stringify(this.form["purchase_date"]).indexOf("-")===-1) {
        this.form["purchase_date"] = this.$toTime(parseInt(this.form["purchase_date"]),"yyyy-MM-dd")
      }
                },

    is_view(){
      var bl = this.user_group == "管理员";

      if(!bl){
        bl = this.$check_action('/elderly_insurance_payment/table','add');
        console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
      }
      if(!bl){
        bl = this.$check_action('/elderly_insurance_payment/table','set');
        console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
      }
      if(!bl){
        bl = this.$check_action('/elderly_insurance_payment/view','add');
        console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
      }
      if(!bl){
        bl = this.$check_action('/elderly_insurance_payment/view','set');
        console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
      }
      if(!bl){
        bl = this.$check_action('/elderly_insurance_payment/view','get');
        console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
      }

      console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

      return bl;
    },

  },
  created() {
                                    this.get_list_user_purchasing_users();
            this.get_group_user_purchasing_users();
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
