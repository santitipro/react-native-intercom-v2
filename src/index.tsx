import { NativeModules } from 'react-native';

type TaxdownIntercomType = {
  multiply(a: number, b: number): Promise<number>;
};

const { TaxdownIntercom } = NativeModules;

export default TaxdownIntercom as TaxdownIntercomType;
