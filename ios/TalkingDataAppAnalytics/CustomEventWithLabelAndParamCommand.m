//
//  CustomEventWithLabelAndParamCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/16.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "CustomEventWithLabelAndParamCommand.h"

@implementation CustomEventWithLabelAndParamCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *custom_event_str = @"\t[TalkingData trackEvent:<#事件 ID#> label:<#事件label#> parameters:<#自定义参数#>];";
    
    [self insertEditableWithInvocation:invocation contents:custom_event_str editPosition:custom_event_str.length + 1];
    
    completionHandler(nil);
}


@end
