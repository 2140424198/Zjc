<template>
	<view class="style">
		<div>
			<form action="post">
				<table>
					<tr>
						<td>输入人数:</td>
						<td><input type="number" placeholder="请输入人数" v-model="numerous"></td>
					</tr>
					<uni-calendar ref="calendar" :insert="false" @confirm="confirm" />
					<button @click="open">打开日历</button>
				</table>
				<button @click="tiajin()">提交</button>
			</form>
		</div>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				linename: "",
				numerous: "",
				price: "",
				predicttime:""
			}
		},
		methods: {
			tiajin() {
				this.$axios({
					method: 'post',
					url: '/order/save',
					params: {
						amount: this.numerous * parseInt(this.price),
						numerous:this.numerous,
						predicttime:this.predicttime,
						status:1
						
					},
					
				}).then(res => {
					console.log(res.data)
				}).catch(err => {
					console.log(err)
				})
				
				
				
				console.log(this.numerous * parseFloat(this.price))
			},
			open() {
				this.$refs.calendar.open();
			},
			confirm(e) {
				console.log(e.fulldate);
				this.predicttime=e.fulldate;
			}
		},
		onLoad(option) { //option为object类型，会序列化上个页面传递的参数
			//打印出上个页面传递的参数。
			console.log(option)
			this.linename = option.name;
			this.price = option.price;

		},
		mounted: {

		}
	}
</script>

<style>
	.style{
		font-family: "SimSun";
	}
</style>
