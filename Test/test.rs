fn main(){
	let mut array= [1,2,3];
	let mut vec:Vec<&str> = Vec::new();

	vec.push("abs");

	for ele in vec{
		println!("{}",ele);
	}
	let subarray = &array[1..];
	println!("{:?}",subarray);
}