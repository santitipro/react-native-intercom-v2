import { NativeModules } from 'react-native';

type TaxdownIntercomType = {
  identifier(options: { userId: string }): Promise<void>;
  displayMessenger(): Promise<void>;
  displayHelpCenterArticle(articleId: string): Promise<void>;
};

const { TaxdownIntercom } = NativeModules;

export default TaxdownIntercom as TaxdownIntercomType;
